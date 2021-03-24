# Class-Test-Management-Software
A JavaFX software which can be used to create routines and seat plans of class tests and assign invigilators to each class test. This software was developed for a requirement of the Object Oriented Programming Language course in Department of Computer Science and Engineering, Bangladesh University of Engineering and Technology.

The main tools used to develop this software are JavaFX and CSS. Multithreading and Socket Programming techniques of Java have been used to implement this software. To run this software, perform the following steps sequentially:

1.  Run the _servermain.java_ file in the 'src/Server' directory, 
2.  Run the _main.java_ file in the 'src/Server/routinegenerator' directory.
3.  Run the _Main.java_ file in the 'src/Login' directory.

Provide correct user name and password according to the data in _user_data.txt_ file in the 'src/TextContent' directory and log in.

## Applications

There are three basic applications of this software:

1. Generating a routine of the class tests of the provided courses and respective credit hours based on the available dates. All of these information should be stored in the respective files in the 'src/TextContent' directory.
2. Providing a student the routine of the class tests for his/her courses and the seat plan of the class tests. Any number of students can see their respective class test routine and seat plan simultaneously.
3. Informing a teacher about the dates of the class tests of the courses that he/she teaches. Moreover this software will inform a teacher about the date and room no. of the class tests that he/she has to invigilate.


# Modes

There are two modes based on the user types: student mode and teacher mode. 

![Screenshot (210)](https://user-images.githubusercontent.com/37974385/112328177-4863e000-8ce0-11eb-987e-f345df6d8f14.png)

After providing the account information in login page, a student can see the following page. 

![Screenshot (211)](https://user-images.githubusercontent.com/37974385/112328236-59acec80-8ce0-11eb-8068-66c9eae2ccd9.png)
![Screenshot (213)](https://user-images.githubusercontent.com/37974385/112328423-83661380-8ce0-11eb-9ae0-b55d0ed266a3.png)

After clicking on the 'View Seat Plan' button, he/she can see his/her seat plan as the following.

![Screenshot (214)](https://user-images.githubusercontent.com/37974385/112328565-a8f31d00-8ce0-11eb-9356-ea4245c4df60.png)


After logging in successfully, a teacher can see the following page which contains the dates of the class tests of the courses he/she teaches. If the credit hour of a course is set _n_ in the respective data file, then the built in class test count is _n+1_.

![Screenshot (215)](https://user-images.githubusercontent.com/37974385/112328731-ce802680-8ce0-11eb-9ab4-1cba54e903e2.png)
![Screenshot (216)](https://user-images.githubusercontent.com/37974385/112328780-d5a73480-8ce0-11eb-84c2-606e500a38ef.png)


After clicking on the 'Invigilations' button, he/she can see the dates and room numbers of the class tests that he/she has to invigilate.

![Screenshot (217)](https://user-images.githubusercontent.com/37974385/112329311-4b130500-8ce1-11eb-81da-1848ee96565f.png)


