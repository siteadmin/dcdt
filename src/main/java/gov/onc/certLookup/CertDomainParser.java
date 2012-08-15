package gov.onc.certLookup;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;

/**
 * Handler for certificate discovery.
 * Parses the email address from the certificate info bean
 * according to the given test case.
 * @author jasonsmith
 *
 */
public class CertDomainParser implements CertLookUpFactory {

	private Logger log = Logger.getLogger("certDiscoveryLogger");
	/**
	 * Parses domain according to the test case for either
	 * address or domain or LDAP or SRV.
	 * Implements the CertLookupInterface.
	 * @param certInfo
	 * @return certInfo
	 * @throws CertLookUpException
	 */
	public CertificateInfo execute(CertificateInfo certInfo)
			throws CertLookUpException {
		log.debug("before CertDomainParser execution.");

		String origDomain = certInfo.getDomain();
		if (certInfo.getIsDomainTest()) {
			certInfo.setDomain(getDomain(origDomain));
		} else {
			if (certInfo.getIsLDAPTest()) {
				certInfo.setDomLdap(getDomain(origDomain));
			}
			certInfo.setDomain(getAddress(origDomain));
		}

		log.debug("after CertDomainParser execution.  Domain = "
			+ certInfo.getDomain());
		return certInfo;
	}

	/**
	 * Strips domain from email address for domain testing.
	 * @param addr
	 * @return
	 * @throws CertLookUpException
	 */
	private String getDomain(String addr) throws CertLookUpException {
		if (addr.contains("@")) {
			String domainName = null;
			StringTokenizer tok = new StringTokenizer(addr, "@");
			while (tok.hasMoreTokens()) {
				domainName = tok.nextToken();
			}
			if (domainName != null) {
				return domainName + ".";
			} else {
				throw new CertLookUpException("Domain Name is incorrect.",
					new Throwable());
			}
		} else {
			return addr + ".";
		}
	}
	
	/**
	 * Replaces at sign with period for address testing.
	 * @param addr
	 * @return
	 */
	private String getAddress(String addr) {
		if (addr.contains("@")) {
			return addr.replace("@", ".") + ".";
		} else {
			return addr + ".";
		}
	}

}
