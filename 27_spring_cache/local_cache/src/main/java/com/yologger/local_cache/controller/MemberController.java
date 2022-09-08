package com.yologger.local_cache.controller;

import com.yologger.local_cache.service.MemberDTO;
import com.yologger.local_cache.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAll() {
        return new ResponseEntity<>(memberService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> findMemberById(@PathVariable Long id) {
        return new ResponseEntity<>(memberService.findMemberById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> updateEmailById(@RequestBody UpdateEmailByIdRequest request) {
        memberService.updatePassword(request.getId(), request.getPassword());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemberById(@PathVariable Long id) {
        memberService.deleteMemberById(id);
        return ResponseEntity.noContent().build();
    }
}
