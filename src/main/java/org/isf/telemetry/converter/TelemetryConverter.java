package org.isf.telemetry.converter;

import org.isf.telemetry.bo.TelemetryBo;
import org.springframework.stereotype.Component;

@Component
public class TelemetryConverter {

	public TelemetryBo toBo(String code, String key, String value, int nextRequestId) {
		TelemetryBo bo = new TelemetryBo();
		bo.setCode(code);
		bo.setKey(key);
		bo.setValue(value);
		bo.setRequestId(nextRequestId);
		return bo;
	}

}
