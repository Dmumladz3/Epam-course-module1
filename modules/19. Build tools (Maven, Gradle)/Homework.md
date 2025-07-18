Build tools & CI/CD task 

 

**Part 1. Build tools**

Download archive (build tools) from [here](<https://git.epam.com/epm-cdp/global-java-foundation-program/java-modules/-/blob/master/modules/19.%20Build%20tools%20(Maven,%20Gradle)/build%20tools.zip>) which contains sources of multi module project with the following structure:

    builders\
    	admin\
    	services\
    	utils\
    	web\

The modules contains only the code without build script. Your homework is to correct configure the build system for the codebase.

1. Choose any of the build system:

   - Ant+Ivy (Optional),
   - Maven
   - Gradle

   to build the project.

2. Two artifacts – war (for web module) and jar (for admin module) should be generated as a result of script running.

3. `builder` parent build script should be able to create child projects.

4. Add the target folders in the `.gitignore` folder.

5. Add `README` file that contain instructions to build project via Ant, Maven, Gradle tools. Instructions must contain command line to start build project.

6. Build script should allow test running. Details about how to run tests should be written in README.

You will get 100 points for this part.
 

**Part 2 (Optional). CI/CD using Jenkins Home Work** 

Setup Jenkins locally 

For CI/CD you should use project from build tools home work 

Use names for job described in brackets (name: $nameOfJob) 

Create continuous Job (name: continuous)

Should build when SCM has changes 

Should build every night at 2:00 AM  

Job should be parameterized with maven or grade (user should be able to choose it in job parameter)   

Use promotion plugin. Should be available two promo stars  

First stars should be applied automatically to successful build (QA) 

Second stars should be applied manually (Prod) 

Create Deploy Job (name: deploy)

Should be parameterized with artifacts prompted with QA star 

 Use Container Deploy plugin  

Setup machine on cloud.epam.com

Setup additional user for Jenkins  

Setup tomcat 

Setup cloud machine as slave on Jenkins 

Create deploy job (name: deploy_cloud)

Should deploy on clod machine 

Should be parameterized with artifacts promoted with Prod star 

Use Container Deploy plugin 

Create PipeLine (delivery_pipeline)

 Job should be parameterized with maven or grade (user should be able to choose it in job parameter)   

 Step Build according to parameter (continuous) 

 Step Deploy on test (deploy job)    

 Check using curl that deployment is successful  (https://curl.haxx.se/download.html) 

 If deployment is successful  deploy on cloud (deploy_cloud) 

