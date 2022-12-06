package org.isf.telemetry.service;

import java.util.Map;
import java.util.Optional;

import org.isf.telemetry.converter.TelemetryConverter;
import org.isf.telemetry.dao.TelemetryDao;
import org.isf.telemetry.dto.TelemetryGenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TelemetryService {

	@Autowired
	private TelemetryDao telemetryDao;

	@Autowired
	private TelemetryConverter telemetryConverter;

	public TelemetryGenericResponse<Boolean> storeData(Map<String, Map<String, String>> telemetryInsertRequest) {
		final int generatedValue = Optional.ofNullable(this.telemetryDao.retrieveNextRequestId()).orElse(0);

		telemetryInsertRequest.forEach((code, map) -> {
			map.forEach((key, value) -> {
				this.telemetryDao.save(this.telemetryConverter.toBo(code, key, value, generatedValue));
			});

		});

		return new TelemetryGenericResponse<Boolean>(true, true);
	}

}
