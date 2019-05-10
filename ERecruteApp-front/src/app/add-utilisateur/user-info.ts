export class UserInfo {
    name: string;
    username: string;
    email: string;
    role: string[];
    password: string;

    constructor(name: string, username: string, email: string, password: string,role: string[]) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = new Array();
        for (let element of role) { 
            this.role.push(element); 
        }
        
    }

}
