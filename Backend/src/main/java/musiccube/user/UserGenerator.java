package musiccube.user;

import musiccube.entities.Role;
import musiccube.entities.RoleName;
import musiccube.entities.User;
import musiccube.repositories.RoleRepository;
import musiccube.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins="${serverAddress}")
public class UserGenerator {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping(
            value = "/usergenerator",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String generateModel() {

        Role user = new Role(RoleName.ROLE_USER);
        Role mod = new Role(RoleName.ROLE_MOD);
        Role admin = new Role(RoleName.ROLE_ADMIN);

        Set<Role> rolesAdmin = new HashSet<>();
        rolesAdmin.add(user);
        rolesAdmin.add(mod);
        rolesAdmin.add(admin);

        Set<Role> rolesMod = new HashSet<>();
        rolesMod.add(user);
        rolesMod.add(mod);

        Set<Role> rolesUser = new HashSet<>();
        rolesUser.add(user);

        User userUser = new User("user",passwordEncoder.encode("user12"), "user", rolesUser);
        User modUser = new User("mod",passwordEncoder.encode("mod123"), "mod", rolesMod);
        User adminUser = new User("admin",passwordEncoder.encode("admin1"), "admin", rolesAdmin);

        userUser.setFirstName("Dawid");
        userUser.setLastName("Buczyński");
        userUser.setAboutUser("Just a normal user");

        roleRepository.save(user);
        roleRepository.save(mod);
        roleRepository.save(admin);

        userService.save(adminUser);
        userService.save(userUser);
        userService.save(modUser);

        return "Model generated.";
    }
}
