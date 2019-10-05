package tests;

import io.qameta.allure.AllureUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.EditProjectPage;

import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;

// класс, содержащий тесты для проверки редактирования проекта
public class EditProjectPageTest extends BaseTest {
    private EditProjectPage projectPage;
    private Random random = new Random();

    private String nameProject, descriptionProject, nameDomains;

    @Test(description = "редактирование проекта")
    @Description(value = "Тест запоминает старые и устанавливает новые имя, описание и домен проекта")
    public void editProjectDetails() {
        projectPage = new EditProjectPage(driver);
        projectPage.enterTestProjectPage().
                getNameProject();
        descriptionProject = projectPage.getDescriptionProject();
        projectPage.editProject();
        nameDomains = projectPage.getDomains();
        projectPage.cleanDomainsArea();
        assertEquals("", projectPage.getDomains());       // проверка кнопки очистки поля "Domains"
        projectPage.setNewNameProject("new name project" + random.nextInt(12)).
                setNewtDescriptionProject("new description project" + random.nextInt(10)).
                setNewDomainsProject("newDomain" + random.nextInt(77) + ".com").
                setEditProject();
    }

    /*  знаю, что тесты должны быть независимыми друг от друго, но данная зависимость логически обоснованна
     *   и сделана в учебных целях: для закрепления полученных знаний
     */

    @Test(description = "имя проекта",
            groups = "check edit project",
            dependsOnMethods = "editProjectDetails",
            expectedExceptions = {AssertionError.class})
    @Description(value = "Тест проверяет изменилось ли имя проекта после редактирования")
    public void checkEditProjectName() {
        projectPage = new EditProjectPage(driver).
                enterTestProjectPage();
        assertEquals(nameProject, projectPage.getNameProject());
    }

    @Test(description = "описание проекта",
            groups = "check edit project",
            dependsOnMethods = "editProjectDetails",
            expectedExceptions = {AssertionError.class})
    @Description(value = "Тест проверяет изменилось ли описание проекта после редактирования")
    public void checkEditProjectDescription() {
        projectPage = new EditProjectPage(driver).
                enterTestProjectPage();
        assertEquals(descriptionProject, projectPage.getDescriptionProject());
    }

    @Test(description = "домен проекта",
            groups = "check edit project",
            dependsOnMethods = {"editProjectDetails", "checkEditProjectName", "checkEditProjectDescription"},
            expectedExceptions = {AssertionError.class})
    @Description(value = "Тест проверяет изменился ли домен проекта после редактирования")
    public void checkEditProjectDomains() {
        projectPage = new EditProjectPage(driver).
                enterTestProjectPage().
                editProject();
        assertEquals(nameDomains, projectPage.getDomains());
    }
}
