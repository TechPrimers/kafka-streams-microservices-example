package com.techprimers.domaincrawler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domain")
public class DomainCrawlerController {


  private DomainCrawlerService domainCrawlerService;

  public DomainCrawlerController(DomainCrawlerService domainCrawlerService) {
    this.domainCrawlerService = domainCrawlerService;
  }

  @GetMapping("/lookup/{name}")
  public String lookup(@PathVariable("name") final String name) {
    domainCrawlerService.crawl(name);
    return "Domain crawler has scrapped your data";
  }
}
