package br.com.aewinformatica.patrimonio.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("api")
public class ApiProperty {

	private String originPermitida = "http://localhost:8080";
	
	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}
}
