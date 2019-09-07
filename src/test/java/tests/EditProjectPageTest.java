package tests;

import org.testng.annotations.Test;
import pages.EditProjectPage;

import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;

// класс, содержащий тесты для проверки редактирования проекта
public class EditProjectPageTest extends BaseTest {
    EditProjectPage projectPage;
    Random random = new Random();

    String nameProject, descriptionProject, nameDomains;

    @Test
    public void testingPageOfProject() {
        projectPage = new EditProjectPage(driver);
        projectPage.enterTestProjectPage();
        nameProject = projectPage.getNameProject();
        descriptionProject = projectPage.getDescriptionProject();
        projectPage.editProject();
        nameDomains = projectPage.getDomains();
        projectPage.cleanDomainsArea();
        assertEquals("", projectPage.getDomains());       // проверка кнопки очистки поля "Domains"
        projectPage.setNewNameProject("new name project" + random.nextInt(12));
        projectPage.setNewtDescriptionProject("new description project" + random.nextInt(10));
        projectPage.setNewDomainsProject("newDomain" + random.nextInt(77) + ".com");
        projectPage.setEditProject();
    }

    /*  знаю, что тесты должны быть независимыми друг от друго, но данная зависимость логически обоснованна
     *   и сделана в учебных целях: для закрепления полученных знаний
     */

    @Test(description = "тесты данной группы проверяют сохранение данных после редактирования проекта",
            groups = "check edit project",
            dependsOnMethods = "testingPageOfProject",
            expectedExceptions = {AssertionError.class})
    public void checkEditProjectName() {
        projectPage = new EditProjectPage(driver);
        projectPage.enterTestProjectPage();
        assertEquals(nameProject, projectPage.getNameProject());

    }

    @Test(groups = "check edit project",
            dependsOnMethods = "testingPageOfProject",
            expectedExceptions = {AssertionError.class})
    public void checkEditProjectDescription() {
        projectPage = new EditProjectPage(driver);
        projectPage.enterTestProjectPage();
        assertEquals(descriptionProject, projectPage.getDescriptionProject());
    }

    @Test(groups = "check edit project",
            dependsOnMethods = {"testingPageOfProject", "checkEditProjectName", "checkEditProjectDescription"},
            expectedExceptions = {AssertionError.class})
    public void checkEditProjectDomains() {
        projectPage = new EditProjectPage(driver);
        projectPage.enterTestProjectPage();
        projectPage.editProject();
        assertEquals(nameDomains, projectPage.getDomains());
    }
}
