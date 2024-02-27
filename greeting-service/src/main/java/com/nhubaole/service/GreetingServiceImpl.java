package com.nhubaole.service;

import com.nhubaole.grpc.GreetingRequest;
import com.nhubaole.grpc.GreetingResponse;
import com.nhubaole.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {

            String message = request.getMessage();
            System.out.println("Received Message: " + message);


            GreetingResponse greetingResponse = GreetingResponse.newBuilder()
                    .setMessage("My name is " + message)
                    .build();

            responseObserver.onNext(greetingResponse);
            responseObserver.onCompleted();
    }
}
