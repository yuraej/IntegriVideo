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
        checkAndReturn(TestData.newProjectPageURL);
        projectsPage.projectsButton();
        checkAndReturn(TestData.projectsPageURL);
        projectsPage.libraryButton();
        checkAndReturn(TestData.libraryURL);
        projectsPage.billingButton();
        checkAndReturn(TestData.billingPageURL);
        projectsPage.logOutButton();
        checkAndReturn(TestData.mainPageURL);
        projectsPage.integriVideoButton();
        checkAndReturn(TestData.mainPageURL);
    }
}
