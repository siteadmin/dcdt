(function ($) {
    $.extend($.dcdt, {
        "admin": $.extend(function () {
            return this;
        }, {
            "setInstanceConfig": function () {
                return $.dcdt.beans.setBean({
                    "data": $.encodeJson({
                        "@type": "request",
                        "items": [
                            instanceConfig
                        ]
                    }),
                    "queryBeanSuccess": function (data, status, jqXhr) {
                        $.dcdt.admin.getInstanceConfig();
                    },
                    "queryBeanErrors": function (data, status, jqXhr) {
                        $.dcdt.beans.addQueryErrors(instanceConfigForm, data);
                    },
                    "postQueryBean": function (jqXhr, status) {
                        instanceConfigForm.dcdt.form.formReady();
                    },
                    "preQueryBean": function (jqXhr, settings) {
                        $.dcdt.beans.clearBeanErrors(instanceConfigForm);
                        
                        instanceConfigForm.dcdt.form.formWait(instanceConfigButtonSet);
                    },
                    "url": URL_ADMIN_INSTANCE_CONFIG_SET
                });
            },
            "removeInstanceConfig": function () {
                return $.dcdt.beans.removeBean({
                    "queryBeanSuccess": function (data, status, jqXhr) {
                        $.dcdt.admin.getInstanceConfig();
                    },
                    "queryBeanErrors": function (data, status, jqXhr) {
                        $.dcdt.beans.addQueryErrors(instanceConfigForm, data);
                    },
                    "postQueryBean": function (jqXhr, status) {
                        instanceConfigForm.dcdt.form.formReady();
                    },
                    "preQueryBean": function (jqXhr, settings) {
                        $.dcdt.beans.clearBeanErrors(instanceConfigForm);
                        
                        instanceConfigForm.dcdt.form.formWait(instanceConfigButtonRm);
                    },
                    "url": URL_ADMIN_INSTANCE_CONFIG_RM
                });
            },
            "getInstanceConfig": function () {
                return $.dcdt.beans.getBean({
                    "queryBeanSuccess": function (data, status, jqXhr) {
                        instanceConfig = data["items"][0];
                    },
                    "queryBeanErrors": function (data, status, jqXhr) {
                        $.dcdt.beans.addQueryErrors(instanceConfigForm, data);
                    },
                    "postQueryBean": function (jqXhr, status) {
                        var instanceConfigDomainName, instanceConfigIpAddr;
                        
                        if (instanceConfig) {
                            instanceConfigInputDomainName.val(instanceConfigDomainName = instanceConfig["domainName"]);
                            instanceConfigInputIpAddr.val(instanceConfigIpAddr = instanceConfig["ipAddr"]);
                        } else {
                            instanceConfigInputDomainName.val("");
                            instanceConfigInputIpAddr.val("");
                        }
                        
                        if (instanceConfigDomainName && instanceConfigIpAddr) {
                            instanceConfigButtonRm.removeAttr("disabled");
                        } else {
                            instanceConfigButtonRm.attr("disabled", "disabled");
                        }
                    },
                    "preQueryBean": function (jqXhr, settings) {
                        instanceConfig = null;
                        
                        $.dcdt.beans.clearBeanErrors(instanceConfigForm);
                    },
                    "url": URL_ADMIN_INSTANCE_CONFIG_GET
                });
            }
        })
    });
    
    var instanceConfigForm, instanceConfigInputDomainName, instanceConfigInputIpAddr, instanceConfigButtons, instanceConfigButtonRm, instanceConfigButtonSet,
        instanceConfig;
    
    $(document).ready(function () {
        instanceConfigForm = $("form[name=\"admin-instance-config\"]");
        instanceConfigInputDomainName = instanceConfigForm.dcdt.form.formInputs("domainName");
        instanceConfigInputIpAddr = instanceConfigForm.dcdt.form.formInputs("ipAddress");
        instanceConfigButtons = instanceConfigForm.dcdt.form.formButtons();
        instanceConfigButtonRm = instanceConfigForm.dcdt.form.formButtons("#admin-instance-config-rm");
        instanceConfigButtonSet = instanceConfigForm.dcdt.form.formButtons("#admin-instance-config-set");
        
        instanceConfigForm.submit(function (event, instanceConfigButton) {
            if (instanceConfigButton.is(instanceConfigButtonRm)) {
                $.dcdt.admin.removeInstanceConfig();
            } else if (instanceConfigButton.is(instanceConfigButtonSet)) {
                instanceConfig = {
                    "@type": "instanceConfig",
                    "domainName": instanceConfigInputDomainName.val(),
                    "ipAddr": instanceConfigInputIpAddr.val()
                };
                
                $.dcdt.admin.setInstanceConfig();
            }
            
            event.preventDefault();
            event.stopPropagation();
        });
        
        instanceConfigButtons.click(function (event) {
            var instanceConfigButton = $(event.target);
            
            if (!instanceConfigButton.attr("disabled")) {
                instanceConfigForm.trigger("submit", [ instanceConfigButton ]);
            }
        });
        
        $.dcdt.admin.getInstanceConfig();
    });
})(jQuery);
