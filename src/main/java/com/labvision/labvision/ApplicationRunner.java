package com.labvision.labvision;

import com.labvision.labvision.model.Image;
import com.labvision.labvision.model.Measurement;
import com.labvision.labvision.model.Sample;
import com.labvision.labvision.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApplicationRunner {
    public static void main(String[] args) {
        User u = new User();
        u.setName("Dr. Alice");
        u.setEmail("alice@lab.com");
        u.setPassword("secret");
        u.setRole("PATOLOGO");
        System.out.println(u);

        Sample s = new Sample();
        s.setUser(u);
        s.setPatient("João Pedro");
        s.setCollectionDate(LocalDate.of(2025, 6, 14));
        s.setTissueType("Biopsia");
        s.setNotes("Nota de exemplo");
        System.out.println(s + " — dias desde coleta: " + s.daysSinceCollection());

        Measurement m = new Measurement();
        m.setSample(s);
        m.setWidthMm(12.5f);
        m.setLengthMm(20.0f);
        m.setHeightMm(5.0f);
        m.setTimestamp(LocalDateTime.now());
        m.setImageData(new byte[]{1,2,3});  // só pra teste
        System.out.println(m);

        Image img = new Image();
        img.setFilename("imagem1.png");
        img.setData(new byte[]{10,20,30,40});
        System.out.println(img + " — tem dados? " + img.hasData());
    }
}
