class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        # first handle +
        unique_emails = set()
        for email in emails:
            domain = email.split('@')[1]
            email = email.split('@')[0]
            if '+' in email:
                email = email.split('+')[0]
            local_name = ''.join(email.split('.'))
            unique_emails.add('@'.join([local_name,domain]))
        return(len(unique_emails))