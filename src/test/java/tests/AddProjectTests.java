package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AddProjectPage;

public class AddProjectTests extends BaseTest {
    AddProjectPage addProjectPage;
    private String name = TestData.projectName;
    private String description = TestData.projectDescription;
    private String domain = TestData.domainName;
    private String text = "test";
    private int numberProject = 4;

    @Test
    public void addProject() {
        addProjectPage = new AddProjectPage(driver)
                .createProject(name, description, domain)
                .choseProject(numberProject)                      // выбирает проект по номеру
                .choseComponent()
                .addComponentVideoChat(text)
                .choseComponent()
                .addComponentMultiDeviceVideoPlayer(text)
                .choseComponent()
                .addComponentSingleVideo(text)
                .choseComponent()
                .addComponentMultiDeviceVideoPlayer(text);
        checkNumberElements(4, driver.findElements(By.cssSelector("div.col-xl-4.col-sm-6")).size()-1);
    }
}
