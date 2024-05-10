package br.com.aewinformatica.patrimonio.config.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("api")
@Component
public class ApiProperty {

	@Value("${api.origin-permitida}")
	private String originPermitida;
	
	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}
}
