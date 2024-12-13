"# Faculty_leave_protal" 
The Leave Management Automation project aims to streamline and automate the leave application and approval process within our university’s VIMS portal. This project addresses the challenges faced in traditional leave management, which often involves manual paperwork, delays, and lack of transparency across different levels.

To solve these issues, our team implemented an automated system that supports efficient leave handling for faculty, Heads of Departments (HODs), and deans. Built using JSP, HTML, CSS, JavaScript, and MySQL, this system provides a user-friendly interface and secure database management for seamless operations.
![image](https://github.com/user-attachments/assets/7e7ee258-ec71-45d5-91c0-1fc558482d58)
Faculty Leave Application Flow :

................................................................................Faculty LeavApplication...........................................................................................

The form shown in the image is a Leave Entry form, where an employee can submit a leave application. It includes fields for the employee's information, such as the date, employee code, name, designation, and department. The form allows the user to select the leave period (from and to dates), leave type (e.g., casual leave), and automatically calculates the balance based on the number of leaves taken. Additional fields display the number of leave days applied and the remaining balance. The user can also enter the purpose of the leave in a text box before submitting the form. After submit it redirects to work adjustment form

![image](https://github.com/user-attachments/assets/b9c1f071-6b67-4ac6-8a52-ac47c2d1b12a)


Faculty Work Adjustment

The image displays a Work Adjustment table for faculty members, covering adjustments for classes between 21-11-2024 and 22-11-2024. It lists details for each class, including course, branch, year, semester, section, subject, date, day, and period. A dropdown menu is provided in the "faculty" column, allowing the selection of a substitute faculty member from a list of names for each specified period. Once the adjustments are made, the form can be submitted. This setup facilitates smooth scheduling adjustments by assigning alternate instructors to cover classes during the faculty's absence. After submit the will sent to every faculty who are assigned.


![image](https://github.com/user-attachments/assets/0770f095-8641-48ca-823b-f612f41d14e0)

Mail Sent to Adjusted faculty:

When a faculty member has been assigned to cover an adjustment, they will receive an email notification with all necessary details. This email will include information such as the course, branch, year, semester, section, subject, and the specifics of the date and time for the adjustment. The aim is to keep faculty members informed of any changes to their schedules, ensuring smooth coverage of classes. The email serves as a formal communication method to notify faculty in advance, allowing them to prepare adequately. This streamlined approach enhances coordination among faculty and minimizes disruptions to students’ learning experiences. Additionally, these email notifications help in managing the workload and maintaining clear records of class adjustments within the institution

![image](https://github.com/user-attachments/assets/88617610-c40d-4975-ac7b-63c59d04dce2)


Substitute faculty approval:

The image shows a Substitute Faculty Approval Page, which is a table listing leave details for an employee. It includes columns for employee code, employee name, leave period (from and to dates), leave type, leave balance, and adjustments. The "adjustments" column lists the substitute faculty members assigned to cover specific periods on the leave dates, along with their names, faculty IDs, and the status of each adjustment (accepted or pending). An "Accept/Deny" checkbox is available for each adjustment, allowing an authorized person to approve or deny the substitute arrangements. Once selections are made, the form can be submitted. The sidebar on the right provides links to various leave-related reports and resources.

![image](https://github.com/user-attachments/assets/4ea9a60d-e293-4058-945f-32a8d5022315)

HOD approval of faculty leave:

The image displays the HOD Approval of Faculty Leave Page, which is a Work Adjustment Form used for approving or denying leave requests for faculty members. It shows a table with columns for year, section, semester, branch, period, subject, date, and status, allowing the HOD to review the details of a specific class adjustment. There are "Accept" and "Deny" checkboxes in the "Status" column, along with a comments section for the HOD to add any remarks related to the decision. Once the decision is made, the HOD can submit the form. Quick links on the right provide access to additional leave-related resources and service request modules.

![image](https://github.com/user-attachments/assets/49666b80-deef-41d8-9498-c98f5f9d1d57)

............................................................................HOD Leave Application Flow.........................................................................................
![image](https://github.com/user-attachments/assets/37f58b9c-2589-4987-8e4d-00c7b14cbb4c)

HOD Leave Application

The image displays a Leave Entry Form for an employee, who is the Head of the Department. The form includes fields for date, employee code, name, designation, department, leave period (from and to dates), leave type (e.g., casual leave), and leave balance. The form automatically calculates the number of leave days applied and updates the remaining balance. The user can also enter the purpose of the leave in a designated text box. After filling in all required information, the form can be submitted. After Submitting the work adjustment will visible

![image](https://github.com/user-attachments/assets/e025c82b-f51b-4bbb-a340-075cb04d04e8)

HOD Work Adjustment:

The image shows a Work Adjustment and Allocation Form designed for department heads to manage class adjustments and delegate responsibilities during their absence. The Faculty Adjustment section displays any classes that need coverage, although in this instance, no classes are listed as requiring adjustments. Below, the Work Allocation section allows the department head to assign another faculty member to take over specific responsibilities or roles temporarily. A dropdown menu provides a list of available faculty members for selection. Once the allocation is finalized, it can be submitted. The right sidebar contains links to personal leave information, service requests, and department leave-related resources for additional support.


![image](https://github.com/user-attachments/assets/98348271-730f-4590-a737-b3ac66bda205)

Dean approval of HOD leave:

The image shows a Dean Approval of HOD Leave Form that allows the dean to review and approve leave requests submitted by department heads. The form includes a table with key details such as employee code, name, leave period, leave type, leave balance, and adjustments. In the "adjustments" column, the role and the designated faculty member assigned to cover duties during the HOD’s absence are specified. The dean can choose to "Accept" or "Deny" the leave request and any adjustments, ensuring responsibilities are covered. Once the decision is finalized, the form can be submitted. The right sidebar provides links to relevant resources and reports for leave management and service requests.

![image](https://github.com/user-attachments/assets/f0a14ce8-9923-4eba-9afb-8ef6ab3feb05)

VC approval of HOD leave:
The image displays a Vice Chancellor (VC) Approval of HOD Leave Form that facilitates the review and approval of leave requests submitted by Heads of Departments (HODs). The form includes a table with essential information such as employee code, name, leave dates, type of leave, current leave balance, and any adjustments made to cover responsibilities during the leave period. In the "adjustments" column, the designated substitute faculty member is specified. The VC has the option to "Accept" or "Deny" the leave request by selecting the appropriate checkbox. After making a decision, the VC can submit the form. The sidebar on the right provides quick links to additional resources, such as leave status, variance reports, and university-related links.

![image](https://github.com/user-attachments/assets/c78bf2ec-2435-495e-9b75-a2055a88f4b0)

