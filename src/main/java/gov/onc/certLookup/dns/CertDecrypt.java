package gov.onc.certLookup.dns;

import gov.onc.certLookup.CertLookUpFactory;
import gov.onc.certLookup.CertificateInfo;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.StringTokenizer;

import org.xbill.DNS.Record;


public class CertDecrypt implements CertLookUpFactory{
	
	public CertificateInfo execute(CertificateInfo certificateInfo){
		BufferedInputStream bis = null;
		try{
			bis = new BufferedInputStream(new ByteArrayInputStream(getCert(certificateInfo.getDnsRecord()[0])));
			CertificateFactory cf;
			cf = CertificateFactory.getInstance("X.509");
			StringBuffer sb = new StringBuffer();
			while (bis.available() > 0) {
				X509Certificate certX509 = (X509Certificate) cf.generateCertificate(bis);
				String certX509_st = certX509.toString();
				if(certX509_st != null)
					sb.append(certX509_st);
			}
			certificateInfo.setCertOutput(sb.toString());
		}catch(Exception e){
			certificateInfo.setCertOutput("Problem Loading Certificate: " + e);
		}finally{
			closeStreamQuietly(bis);
		}
		return certificateInfo;
	}
	
	
	
	private byte[] getCert(Record record) throws IOException{
		
		String recordStr = record.rdataToString();
		StringTokenizer st = new StringTokenizer(recordStr);
		int i = 0;
		
		while(st.hasMoreTokens() && i < 3){
			st.nextToken();
			i++;
		}
		
		String cert = st.nextToken().toString();
		return new sun.misc.BASE64Decoder().decodeBuffer(cert);
	}
	
	private void closeStreamQuietly(Closeable stream){
		try{
			if(stream != null)
				stream.close();
		}catch(IOException e){
			//TODO do nothing for now (add logging functionality later)
		}
	}
	
}