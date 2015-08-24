package net.upliftinglemma.blog;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import net.upliftinglemma.blog.dao.PersonRepository;
import net.upliftinglemma.blog.model.Person;

@Component
public class DatabaseSetup implements ApplicationListener<ContextRefreshedEvent> {

    private static final Log LOG = LogFactory.getLog(DatabaseSetup.class);

    private final PersonRepository personRepository;

    @Autowired
    public DatabaseSetup(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        final long count = personRepository.count();

        // Make sure there are some persons
        if (count == 0) {
            LOG.info("Creating some persons...");

            final Person chris = new Person();
            chris.setName("chris");
            chris.setAdmin(true);
            personRepository.save(chris);

            final Person mary = new Person();
            mary.setName("mary");
            personRepository.save(mary);
        }
    }

}
