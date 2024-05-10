const ValidateField = (name, value) => {
    if (value.trim() === ""){
        return `${name} is required.`;
    }
    else
    {
        switch (name) {
            case 'username':
                if (!value.match(/^[a-zA-Z ]{2,30}$/)) {
                    return  'Name must be at least 3 characters long.';
                }
                break;
            case 'email':
                if (!value.match(/^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/)) {
                    return 'Email address is invalid.';
                }
                
                break;
            case 'password':
                if (!value.match(/^[a-zA-Z0-9!@#$%^&*]{6,16}$/)) {
                    return 'Password must be 6-16 characters and include atleast one number.';
                }
                break;
            // case 'confirmPassword':
            //     if (value !== formData.password) {
            //         return 'Passwords do not match.';
            //     }
            //     break;
            default:
                return '';
        }
    }
  };

  export default ValidateField;