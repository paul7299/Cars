package dat3.car.api;

import dat3.car.dto.MemberRequest;
import dat3.car.dto.MemberResponse;
import dat3.car.entity.Member;
import dat3.car.repository.MemberRepository;
import dat3.car.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Denne kontroller ved at når det kommer JSON kan den lave det om til et objekt
@RequestMapping("api/members")
class MemberController {

    MemberService memberService;


    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // @Autowired  //Deliberately added via Autowired, remove this endpoint when you know why it's bad

    /* @GetMapping("/bad")
    public List<Member> getMembersBad(){
        return memberRepository.findAll();
    } */

    /* ------- CRUD API BELOW -------  */

    //Security: Admin Only
    @GetMapping
    List<MemberResponse> getMembers(){
        return memberService.getMembers(false);
    }

    //Security: Admin
    @GetMapping(path = "/{username}")
    MemberResponse getMemberById(@PathVariable String username) throws Exception {
        return memberService.findById(username);
    }


    //Security: Anonymous
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MemberResponse addMember(@RequestBody MemberRequest body){
        return memberService.addMember(body);
    }

    //Security: Member
    @PutMapping("/{username}")
    ResponseEntity<Boolean> editMember(@RequestBody MemberRequest body, @PathVariable String username){
        return memberService.editMember(body, username);
    }

    //Security: Admin
    @PatchMapping("/ranking/{username}/{value}")
    void setRankingForUser(@PathVariable String username, @PathVariable int value) {
        memberService.setRankingForUser(username, value);
    }

    // Security: Admin
    @DeleteMapping("/{username}")
    void deleteMemberByUsername(@PathVariable String username) {
        memberService.deleteMemberByUsername(username);
    }



}
