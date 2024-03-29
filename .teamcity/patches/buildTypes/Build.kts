package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    check(artifactRules == "") {
        "Unexpected option value: artifactRules = $artifactRules"
    }
    artifactRules = "*.txt"

    expectSteps {
        maven {
            goals = "clean compile"
        }
        script {
            id = "set-custom-green-text"
            scriptContent = """echo "##teamcity[buildStatus text='Eugene Success in executing the step']""""
        }
        script {
            id = "set-custom-red-text"
            executionMode = BuildStep.ExecutionMode.RUN_ONLY_ON_FAILURE
            scriptContent = """echo "##teamcity[buildStatus text='Eugene Build Failed in executing the step']""""
        }
    }
    steps {
        insert(3) {
            step {
                name = "AddStepCustomRunner"
                id = "AddStepCustomRunner"
                type = "Eugene RunType"
                param("Eugene Test Message", "This will succeed")
            }
        }
    }
}
