package com.yologger.grpc.grpcclient;

import com.yologger.grpc.service.TestReply;
import com.yologger.grpc.service.TestRequest;
import com.yologger.grpc.service.TestServiceGrpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {
    @GrpcClient("test")
    private TestServiceGrpc.TestServiceBlockingStub stub;

    public String doTest(String data) {
        try {
            TestRequest request = TestRequest.newBuilder().setData(data).build();
            TestReply reply = stub.doTest(request);
            return reply.getMessage();
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }
}
