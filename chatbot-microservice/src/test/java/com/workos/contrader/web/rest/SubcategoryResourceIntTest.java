package com.workos.contrader.web.rest;

import com.workos.contrader.ChatbotApp;

import com.workos.contrader.domain.Subcategory;
import com.workos.contrader.domain.Category;
import com.workos.contrader.repository.SubcategoryRepository;
import com.workos.contrader.service.SubcategoryService;
import com.workos.contrader.service.dto.SubcategoryDTO;
import com.workos.contrader.service.mapper.SubcategoryMapper;
import com.workos.contrader.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static com.workos.contrader.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the SubcategoryResource REST controller.
 *
 * @see SubcategoryResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChatbotApp.class)
public class SubcategoryResourceIntTest {

    private static final String DEFAULT_SUBCATEGORY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SUBCATEGORY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SUBCAT_HELP_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_SUBCAT_HELP_MESSAGE = "BBBBBBBBBB";

    @Autowired
    private SubcategoryRepository subcategoryRepository;


    @Autowired
    private SubcategoryMapper subcategoryMapper;
    

    @Autowired
    private SubcategoryService subcategoryService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restSubcategoryMockMvc;

    private Subcategory subcategory;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SubcategoryResource subcategoryResource = new SubcategoryResource(subcategoryService);
        this.restSubcategoryMockMvc = MockMvcBuilders.standaloneSetup(subcategoryResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Subcategory createEntity(EntityManager em) {
        Subcategory subcategory = new Subcategory()
            .subcategoryName(DEFAULT_SUBCATEGORY_NAME)
            .subcatHelpMessage(DEFAULT_SUBCAT_HELP_MESSAGE);
        // Add required entity
        Category category = CategoryResourceIntTest.createEntity(em);
        em.persist(category);
        em.flush();
        subcategory.setCategory(category);
        return subcategory;
    }

    @Before
    public void initTest() {
        subcategory = createEntity(em);
    }

    @Test
    @Transactional
    public void createSubcategory() throws Exception {
        int databaseSizeBeforeCreate = subcategoryRepository.findAll().size();

        // Create the Subcategory
        SubcategoryDTO subcategoryDTO = subcategoryMapper.toDto(subcategory);
        restSubcategoryMockMvc.perform(post("/api/subcategories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(subcategoryDTO)))
            .andExpect(status().isCreated());

        // Validate the Subcategory in the database
        List<Subcategory> subcategoryList = subcategoryRepository.findAll();
        assertThat(subcategoryList).hasSize(databaseSizeBeforeCreate + 1);
        Subcategory testSubcategory = subcategoryList.get(subcategoryList.size() - 1);
        assertThat(testSubcategory.getSubcategoryName()).isEqualTo(DEFAULT_SUBCATEGORY_NAME);
        assertThat(testSubcategory.getSubcatHelpMessage()).isEqualTo(DEFAULT_SUBCAT_HELP_MESSAGE);
    }

    @Test
    @Transactional
    public void createSubcategoryWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = subcategoryRepository.findAll().size();

        // Create the Subcategory with an existing ID
        subcategory.setId(1L);
        SubcategoryDTO subcategoryDTO = subcategoryMapper.toDto(subcategory);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSubcategoryMockMvc.perform(post("/api/subcategories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(subcategoryDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Subcategory in the database
        List<Subcategory> subcategoryList = subcategoryRepository.findAll();
        assertThat(subcategoryList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkSubcategoryNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = subcategoryRepository.findAll().size();
        // set the field null
        subcategory.setSubcategoryName(null);

        // Create the Subcategory, which fails.
        SubcategoryDTO subcategoryDTO = subcategoryMapper.toDto(subcategory);

        restSubcategoryMockMvc.perform(post("/api/subcategories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(subcategoryDTO)))
            .andExpect(status().isBadRequest());

        List<Subcategory> subcategoryList = subcategoryRepository.findAll();
        assertThat(subcategoryList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSubcatHelpMessageIsRequired() throws Exception {
        int databaseSizeBeforeTest = subcategoryRepository.findAll().size();
        // set the field null
        subcategory.setSubcatHelpMessage(null);

        // Create the Subcategory, which fails.
        SubcategoryDTO subcategoryDTO = subcategoryMapper.toDto(subcategory);

        restSubcategoryMockMvc.perform(post("/api/subcategories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(subcategoryDTO)))
            .andExpect(status().isBadRequest());

        List<Subcategory> subcategoryList = subcategoryRepository.findAll();
        assertThat(subcategoryList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSubcategories() throws Exception {
        // Initialize the database
        subcategoryRepository.saveAndFlush(subcategory);

        // Get all the subcategoryList
        restSubcategoryMockMvc.perform(get("/api/subcategories?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(subcategory.getId().intValue())))
            .andExpect(jsonPath("$.[*].subcategoryName").value(hasItem(DEFAULT_SUBCATEGORY_NAME.toString())))
            .andExpect(jsonPath("$.[*].subcatHelpMessage").value(hasItem(DEFAULT_SUBCAT_HELP_MESSAGE.toString())));
    }
    

    @Test
    @Transactional
    public void getSubcategory() throws Exception {
        // Initialize the database
        subcategoryRepository.saveAndFlush(subcategory);

        // Get the subcategory
        restSubcategoryMockMvc.perform(get("/api/subcategories/{id}", subcategory.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(subcategory.getId().intValue()))
            .andExpect(jsonPath("$.subcategoryName").value(DEFAULT_SUBCATEGORY_NAME.toString()))
            .andExpect(jsonPath("$.subcatHelpMessage").value(DEFAULT_SUBCAT_HELP_MESSAGE.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSubcategory() throws Exception {
        // Get the subcategory
        restSubcategoryMockMvc.perform(get("/api/subcategories/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSubcategory() throws Exception {
        // Initialize the database
        subcategoryRepository.saveAndFlush(subcategory);

        int databaseSizeBeforeUpdate = subcategoryRepository.findAll().size();

        // Update the subcategory
        Subcategory updatedSubcategory = subcategoryRepository.findById(subcategory.getId()).get();
        // Disconnect from session so that the updates on updatedSubcategory are not directly saved in db
        em.detach(updatedSubcategory);
        updatedSubcategory
            .subcategoryName(UPDATED_SUBCATEGORY_NAME)
            .subcatHelpMessage(UPDATED_SUBCAT_HELP_MESSAGE);
        SubcategoryDTO subcategoryDTO = subcategoryMapper.toDto(updatedSubcategory);

        restSubcategoryMockMvc.perform(put("/api/subcategories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(subcategoryDTO)))
            .andExpect(status().isOk());

        // Validate the Subcategory in the database
        List<Subcategory> subcategoryList = subcategoryRepository.findAll();
        assertThat(subcategoryList).hasSize(databaseSizeBeforeUpdate);
        Subcategory testSubcategory = subcategoryList.get(subcategoryList.size() - 1);
        assertThat(testSubcategory.getSubcategoryName()).isEqualTo(UPDATED_SUBCATEGORY_NAME);
        assertThat(testSubcategory.getSubcatHelpMessage()).isEqualTo(UPDATED_SUBCAT_HELP_MESSAGE);
    }

    @Test
    @Transactional
    public void updateNonExistingSubcategory() throws Exception {
        int databaseSizeBeforeUpdate = subcategoryRepository.findAll().size();

        // Create the Subcategory
        SubcategoryDTO subcategoryDTO = subcategoryMapper.toDto(subcategory);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restSubcategoryMockMvc.perform(put("/api/subcategories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(subcategoryDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Subcategory in the database
        List<Subcategory> subcategoryList = subcategoryRepository.findAll();
        assertThat(subcategoryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSubcategory() throws Exception {
        // Initialize the database
        subcategoryRepository.saveAndFlush(subcategory);

        int databaseSizeBeforeDelete = subcategoryRepository.findAll().size();

        // Get the subcategory
        restSubcategoryMockMvc.perform(delete("/api/subcategories/{id}", subcategory.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Subcategory> subcategoryList = subcategoryRepository.findAll();
        assertThat(subcategoryList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Subcategory.class);
        Subcategory subcategory1 = new Subcategory();
        subcategory1.setId(1L);
        Subcategory subcategory2 = new Subcategory();
        subcategory2.setId(subcategory1.getId());
        assertThat(subcategory1).isEqualTo(subcategory2);
        subcategory2.setId(2L);
        assertThat(subcategory1).isNotEqualTo(subcategory2);
        subcategory1.setId(null);
        assertThat(subcategory1).isNotEqualTo(subcategory2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SubcategoryDTO.class);
        SubcategoryDTO subcategoryDTO1 = new SubcategoryDTO();
        subcategoryDTO1.setId(1L);
        SubcategoryDTO subcategoryDTO2 = new SubcategoryDTO();
        assertThat(subcategoryDTO1).isNotEqualTo(subcategoryDTO2);
        subcategoryDTO2.setId(subcategoryDTO1.getId());
        assertThat(subcategoryDTO1).isEqualTo(subcategoryDTO2);
        subcategoryDTO2.setId(2L);
        assertThat(subcategoryDTO1).isNotEqualTo(subcategoryDTO2);
        subcategoryDTO1.setId(null);
        assertThat(subcategoryDTO1).isNotEqualTo(subcategoryDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(subcategoryMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(subcategoryMapper.fromId(null)).isNull();
    }
}
