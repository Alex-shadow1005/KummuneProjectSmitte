package com.examplelag.kummuneprojectsmitte.config;

import com.examplelag.kummuneprojectsmitte.Model.County;
import com.examplelag.kummuneprojectsmitte.Repo.CountyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InitData implements CommandLineRunner {

    @Autowired
    CountyRepo countyRepo;

    @Override
    public void run(String... args) throws Exception {
        County county = new County();
        county.setName("Rskilde");
        county.setCountyCode("0265");
        county.setHref("https://localhost:0808/county/0265");
        countyRepo.save(county);

        county.setName("Køge");
        county.setCountyCode("0259");
        county.setHref("https://localhost:0808/county/0259");
        countyRepo.save(county);

    }
}
