package com.equifax.trial.backend.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkerRest extends Rest{
    @JsonProperty("resultados")
    private WorkerResponse workerResponse = new WorkerResponse();

    public WorkerResponse getWorkerResponse() {
        return workerResponse;
    }

    public void setWorkerResponse(WorkerResponse workerResponse) {
        this.workerResponse = workerResponse;
    }
}
