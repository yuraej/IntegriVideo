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

    @Test
    public void addProject() {
        addProjectPage = new AddProjectPage(driver)
                .createProject(name, description, domain)
                .choseProject()
                .addComponentVideoChat(text)
                .addComponentMultiDeviceVideoPlayer(text)
                .addComponentSingleVideo(text)
                .addComponentMultiPartyVideo(text);
        checkNumberElements(4, addProjectPage.getNumberProjectsOrComponents() - 1);
    }
}
