package com.yologger.spring_webflux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class MemberHandler {

    public Mono<ServerResponse> getMemberById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        Member member = Member.builder().id(id).email("paul@gmail.com").password("1234").build();
        Mono<Member> response = Mono.just(member);
        return ok().contentType(MediaType.APPLICATION_JSON).body(response, Member.class);
    }

    public Mono<ServerResponse> getAllMembers(ServerRequest request) {
        Member[] members = {
                Member.builder().id(1L).email("paul@gmail.com").password("1234").build(),
                Member.builder().id(2L).email("smith@gmail.com").password("1234").build(),
                Member.builder().id(3L).email("jane@gmail.com").password("1234").build()
        };
        Flux<Member> response = Flux.fromArray(members);
        return ok().contentType(MediaType.APPLICATION_JSON).body(response, Member.class);
    }

    public Mono<ServerResponse> addMember(ServerRequest request) {
        Mono<AddMemberRequest> addMemberRequest = request.bodyToMono(AddMemberRequest.class);
        Mono<Member> member = addMemberRequest.map((r) -> Member.builder()
                .id(1L)
                .email(r.getEmail())
                .password(r.getPassword())
                .build()
        );
        return ok().contentType(MediaType.APPLICATION_JSON).body(member, Member.class);
    }
}
