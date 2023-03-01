package dev.demonboat.mortgageplan.rest;

import dev.demonboat.mortgageplan.model.Prospect;
import dev.demonboat.mortgageplan.rest.create.CreateProspect;
import dev.demonboat.mortgageplan.rest.create.CreateProspectUtil;
import dev.demonboat.mortgageplan.service.ProspectService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/prospects/")
public class ApiController  {

  private ProspectService prospectService;

  private List<Prospect> prospects = new ArrayList<>();

  public ApiController(final ProspectService prospectService) {
    this.prospectService = prospectService;
    this.prospects.addAll(prospectService.getProspects());
  }

  @Operation(summary = "Get all defined prospects with fixed monthly rate")
  @GetMapping("/")
  public ResponseEntity<List<Prospect>> getProspects() {
    return new ResponseEntity<>(prospects, HttpStatus.OK);
  }

  @Operation(summary = "Get all defined prospects with fixed monthly rate")
  @PostMapping("/new")
  public ResponseEntity<Void> createNewProspect(@RequestBody final CreateProspect prospect) {
    if (prospect == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    prospects.add(CreateProspectUtil.prospectFromCreateProspect(prospect));
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
