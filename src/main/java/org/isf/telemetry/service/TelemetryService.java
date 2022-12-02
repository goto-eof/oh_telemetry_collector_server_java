package org.isf.telemetry.service;

import org.isf.telemetry.converter.TelemetryConverter;
import org.isf.telemetry.dao.TelemetryDao;
import org.isf.telemetry.dto.KeyValue;
import org.isf.telemetry.dto.TelemetryGenericResponse;
import org.isf.telemetry.dto.TelemetryInsertRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TelemetryService {

	@Autowired
	private TelemetryDao telemetryDao;

	@Autowired
	private TelemetryConverter telemetryConverter;

	public TelemetryGenericResponse<Boolean> storeData(TelemetryInsertRequest telemetryInsertRequest) {

		Integer generatedValue = this.telemetryDao.retrieveNextRequestId();
		if (generatedValue == null) {
			generatedValue = 0;
		}

		for (KeyValue key : telemetryInsertRequest.getData()) {
			this.telemetryDao.save(this.telemetryConverter.toBo(key, generatedValue));
		}

		TelemetryGenericResponse<Boolean> result = new TelemetryGenericResponse<Boolean>();
		result.setResult(true);
		result.setSuccess(true);
		return result;
	}

}
