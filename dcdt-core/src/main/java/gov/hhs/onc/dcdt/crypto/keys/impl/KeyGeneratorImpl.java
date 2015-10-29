package gov.hhs.onc.dcdt.crypto.keys.impl;

import gov.hhs.onc.dcdt.crypto.CryptographyConfig.GenerateConstraintGroup;
import gov.hhs.onc.dcdt.crypto.CryptographyException;
import gov.hhs.onc.dcdt.crypto.impl.AbstractCryptographyGenerator;
import gov.hhs.onc.dcdt.crypto.keys.KeyConfig;
import gov.hhs.onc.dcdt.crypto.keys.KeyException;
import gov.hhs.onc.dcdt.crypto.keys.KeyGenerator;
import gov.hhs.onc.dcdt.crypto.keys.KeyInfo;
import gov.hhs.onc.dcdt.crypto.utils.KeyUtils;
import gov.hhs.onc.dcdt.utils.ToolClassUtils;
import gov.hhs.onc.dcdt.utils.ToolStringUtils;
import gov.hhs.onc.dcdt.utils.ToolValidationUtils;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component("keyGenImpl")
public class KeyGeneratorImpl extends AbstractCryptographyGenerator<KeyConfig, KeyInfo> implements KeyGenerator {
    @Resource(name = "secureRandomSha1")
    private SecureRandom secureRandom;

    @Override
    public KeyInfo generateKeys(KeyConfig keyConfig) throws CryptographyException {
        BindingResult keyConfigBindingResult = this.validateConfig(keyConfig, GenerateConstraintGroup.class);

        if (keyConfigBindingResult.hasErrors()) {
            throw new KeyException(String.format("Invalid key configuration (class=%s): %s", ToolClassUtils.getName(keyConfig),
                ToolStringUtils.joinDelimit(ToolValidationUtils.mapErrorMessages(this.msgSourceValidation, keyConfigBindingResult).entrySet(), ", ")));
        }

        KeyPairGenerator keyPairGen = KeyUtils.getKeyPairGenerator(keyConfig.getKeyAlgorithm());
        // noinspection ConstantConditions
        keyPairGen.initialize(keyConfig.getKeySize(), this.secureRandom);

        return new KeyInfoImpl(keyPairGen.generateKeyPair());
    }
}
