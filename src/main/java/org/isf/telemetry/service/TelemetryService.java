package org.isf.telemetry.service;

import java.util.Optional;

import org.isf.telemetry.converter.TelemetryConverter;
import org.isf.telemetry.dao.TelemetryDao;
import org.isf.telemetry.dto.TelemetryGenericResponse;
import org.isf.telemetry.dto.TelemetryInsertRequest;
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

	public TelemetryGenericResponse<Boolean> storeData(TelemetryInsertRequest telemetryInsertRequest) {
		final int generatedValue = Optional.ofNullable(this.telemetryDao.retrieveNextRequestId()).orElse(0);
		telemetryInsertRequest.getData().forEach(item -> {
			this.telemetryDao.save(this.telemetryConverter.toBo(item, generatedValue));
		});
		return  new TelemetryGenericResponse<Boolean>(true, true);
	}

}
