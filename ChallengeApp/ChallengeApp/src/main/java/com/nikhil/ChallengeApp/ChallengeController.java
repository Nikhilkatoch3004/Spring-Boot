package com.nikhil.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private ChallengeService challengeService ;

    public ChallengeController(ChallengeService challengeService){
    this.challengeService = challengeService ;
    }

    @GetMapping
    public List<Challenge> getAllChallenges(){
        return challengeService.getAllChallenges() ;
    }

    @PostMapping
    public ResponseEntity<String> addChallenges(@RequestBody Challenge challenge){
        boolean isChallengeAdded = challengeService.addChallenges(challenge);
        if(isChallengeAdded){
            return new ResponseEntity<>("Challenge Added SuccessFully",HttpStatus.OK) ;
        }
       else{
           return new ResponseEntity<>("Challenge Not Added SuccessFully",HttpStatus.NOT_FOUND) ;
        }

    }

    @GetMapping("{month}")
    public ResponseEntity<Challenge> getAChallenges(@PathVariable String month){
        Challenge challenge = challengeService.getAChallenges(month) ;
        if(challenge != null){
            return  new ResponseEntity<>(challenge , HttpStatus.OK) ;
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id ,@RequestBody Challenge challenge){
        boolean isChallengeUpdated = challengeService.updateChallenge(id , challenge);
        if(isChallengeUpdated){
            return new ResponseEntity<>("Challenge Updated SuccessFully",HttpStatus.OK) ;
        }
        else{
            return new ResponseEntity<>("Challenge Not Updated SuccessFully",HttpStatus.NOT_FOUND) ;
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted){
            return new ResponseEntity<>("Challenge Deleted SuccessFully ",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Challenge Not Deleted SuccessFully ",HttpStatus.NOT_FOUND);
        }
    }


}
