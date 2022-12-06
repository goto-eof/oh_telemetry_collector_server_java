package org.isf.telemetry.dto;

public class TelemetryGenericResponse<T> {

	private boolean status;
	private T result;

	public TelemetryGenericResponse(boolean status, T result) {
		this.status = status;
		this.result = result;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
