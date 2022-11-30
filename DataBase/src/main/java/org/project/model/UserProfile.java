package org.project.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "USER_PROFILE")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PROFILENAME")
    private String profilename;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "PHONE")
    private Integer phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "IS_BLOCKET_PROFILE")
    private Boolean isBlockedProfile;
    @Column(name = "USER_ID")
    private Long userId;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy="userProfile"
    )
    private List<PassengerProfile> passengerProfileList;
}

