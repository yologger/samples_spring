package com.yologger.grpc.grpcserver;

import com.yologger.grpc.service.TestReply;
import com.yologger.grpc.service.TestRequest;
import com.yologger.grpc.service.TestServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServerService extends TestServiceGrpc.TestServiceImplBase {

    @Override
    public void doTest(TestRequest request, StreamObserver<TestReply> responseObserver) {
        TestReply reply = TestReply.newBuilder()
                .setMessage("reply: " + request.getData())
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();;
    }
}
