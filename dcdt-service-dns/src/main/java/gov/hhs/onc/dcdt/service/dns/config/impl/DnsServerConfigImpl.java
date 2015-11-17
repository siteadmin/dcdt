package gov.hhs.onc.dcdt.service.dns.config.impl;

import gov.hhs.onc.dcdt.config.instance.InstanceDnsConfig;
import gov.hhs.onc.dcdt.config.instance.impl.InstanceDnsConfigImpl.AuthoritativeDnsConfigPredicate;
import gov.hhs.onc.dcdt.dns.DnsRecordType;
import gov.hhs.onc.dcdt.dns.DnsTransportProtocol;
import gov.hhs.onc.dcdt.service.config.impl.AbstractToolServerConfig;
import gov.hhs.onc.dcdt.service.dns.config.DnsServerConfig;
import gov.hhs.onc.dcdt.utils.ToolEnumUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;

public class DnsServerConfigImpl extends AbstractToolServerConfig<DnsTransportProtocol> implements DnsServerConfig {
    @Autowired(required = false)
    private List<InstanceDnsConfig> configs;

    public DnsServerConfigImpl() {
        super("DNS");
    }

    @Override
    public List<InstanceDnsConfig> findAuthoritativeConfigs(Record questionRecord) {
        // noinspection ConstantConditions
        return this.findAuthoritativeConfigs(ToolEnumUtils.findByCode(DnsRecordType.class, questionRecord.getType()), questionRecord.getName());
    }

    @Override
    public List<InstanceDnsConfig> findAuthoritativeConfigs(DnsRecordType questionRecordType, Name questionName) {
        return CollectionUtils.select(this.configs, new AuthoritativeDnsConfigPredicate(questionRecordType, questionName),
            new ArrayList<>(CollectionUtils.size(this.configs)));
    }

    @Override
    public boolean hasConfigs() {
        return !CollectionUtils.isEmpty(this.configs);
    }

    @Nullable
    @Override
    public List<InstanceDnsConfig> getConfigs() {
        return this.configs;
    }
}
