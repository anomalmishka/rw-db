package org.project.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "PASSENGER_PROFILE")
public class PassengerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PASSENGERNAME")
    private String passengername;
    @Column(name = "PASSENGERLASTNAME")
    private String passengerlastname;
    @Column(name = "PASSPORT_NUMBER")
    private String passportNumber;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "USER_PROFILE_ID")
    private UserProfile userProfile;
}
