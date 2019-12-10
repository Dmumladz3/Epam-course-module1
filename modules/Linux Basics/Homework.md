**Linux Basics task**
=======================


1. Setup Linux OS (it can be your own Linux based OS or setup it by installing VirtualBox + Unix based OS on your Windows machine)
2. All your input/output from console should be sent to your mentor after all task completion. So, take care about it before starting your task (think how will you get this information)
3. Simple commands (1 point)
    a. Print 'CDP JaMP' on the screen
    b. Print OS information (name, kernel, etc.)
    c. Print current user
    d. Print current path
    e. Change your password
    f. Print current date
    g. Print current time
4. Navigation commands (2 points)
    a. Print full path of your home directory
    b. Go to home directory
    c. Get all files in the current directory
    d. Create new folder 'test'
    e. Rename 'test' folder to 'newTest'
    f. Go to 'newTest' folder
    g. Get current date and save the output to the file 'nowFile'
    h. Copy file 'nowFile'. New file name is 'copyOfNowFile'
    i. Get all files information (including date of creation, who created, etc.)
    j. Create empty file 'emptyFile' without text editor
    k. Go up(back to home)
    l. Delete 'newTest' folder
5. Permissions (1 point)
    a. Get all files in the current directory
    b. Create new folder 'permission'
    c. Go to this directory
    d. Create new file 'secretFile' with content 'This is very secret info'
    e. Change permission of this file so that no one can read it.
    f. Get list of files in the current directory with permissions information
    g. Try to read information from file
6. Processes (2 points)
    a. Get list of all running processes
    b. Get list of all running processes with CPU and memory usage
    c. Get list of all running processes of your user
    d. Get dynamic real-time view list of processes that are currently being managed by the Linux kernel (CPU, Memory Usage, etc.).
    e. Sort previous list by Memory Usage.
7. Sort task (4 points). Create script that will create txt file with random 5000000 numbers between 0 and 100000. Try to sort this file using standard Linux command. Try to do the same with Java application. What is time of sorting with Java and with Linux commands? What is the size of source file that should be sorted?

Try to run this script asynchronously (read about nohup). Try to look into a file in runtime while numbers generation (read about tail). Try to kill this process in the middle of numbers generation (read about kill).

Just to think...What will you do if source file size will be 20GB? Is your Java application ready for this?