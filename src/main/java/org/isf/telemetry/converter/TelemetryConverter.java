package org.isf.telemetry.converter;

import org.isf.telemetry.bo.TelemetryBo;
import org.isf.telemetry.dto.KeyValue;
import org.springframework.stereotype.Component;

@Component
public class TelemetryConverter {

	public TelemetryBo toBo(KeyValue dto, int nextRequestId) {
		TelemetryBo bo = new TelemetryBo();
		bo.setCode(dto.getCode());
		bo.setKey(dto.getKey());
		bo.setValue(dto.getValue());
		bo.setRequestId(nextRequestId);
		return bo;
	}

}
