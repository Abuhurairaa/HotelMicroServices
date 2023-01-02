package com.ab.user.service.entities;

import lombok.*;

@NoArgsConstructor
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Hotel {
    //
    private String id;
    private String name;
    private String location;
    private String about;
}
