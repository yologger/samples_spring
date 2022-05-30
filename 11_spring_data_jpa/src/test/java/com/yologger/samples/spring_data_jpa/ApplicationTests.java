package com.yologger.samples.spring_data_jpa;

import com.yologger.samples.spring_data_jpa.repository.MemberEntity;
import com.yologger.samples.spring_data_jpa.repository.MemberRepository;
import com.yologger.samples.spring_data_jpa.repository.PostEntity;
import com.yologger.samples.spring_data_jpa.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest
class ApplicationTests {

}
