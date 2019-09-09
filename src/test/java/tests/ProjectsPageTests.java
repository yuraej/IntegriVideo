package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ProjectsPage;

import static org.testng.AssertJUnit.assertEquals;

public class ProjectsPageTests extends BaseTest {
    ProjectsPage projectsPage;

    @Test(description = "проверяем работоспособность 'кнопок' на странице ПРОЕКТОВ")
    public void testingProjectPage() {
        projectsPage = new ProjectsPage(driver);
        projectsPage.addProjectsButton();
        checkCurrentURLAndGoBack(TestData.newProjectPageURL);
        projectsPage.projectsButton();
        checkCurrentURLAndGoBack(TestData.projectsPageURL);
        projectsPage.libraryButton();
        checkCurrentURLAndGoBack(TestData.libraryURL);
        projectsPage.billingButton();
        checkCurrentURLAndGoBack(TestData.billingPageURL);
        projectsPage.logOutButton();
        checkCurrentURLAndGoBack(TestData.mainPageURL);
        projectsPage.integriVideoButton();
        checkCurrentURLAndGoBack(TestData.mainPageURL);
    }
}
