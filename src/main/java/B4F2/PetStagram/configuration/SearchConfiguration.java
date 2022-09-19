package B4F2.PetStagram.configuration;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SearchConfiguration {

    @Bean
    public Trie<String, String> trie() {
        return new PatriciaTrie<>();
    }
}
