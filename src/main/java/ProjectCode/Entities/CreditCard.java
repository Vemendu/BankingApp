package ProjectCode.Entities;



import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int creditCardId;
    private StringBuilder creditCardNumber = new StringBuilder();
    private final Date expireDate;
    private final int CVV;

    public CreditCard()
    {
        this.expireDate = null;
        this.CVV = -1;
    }
    public CreditCard(Date date)
    {
        for(int i=0; i<16; i++)
        {
            if((i)%4==3)
            {
                creditCardNumber.append(" ");
            }
            creditCardNumber.append((int)(Math.random()*10));

        }
        this.expireDate = date;
        CVV = (int)(Math.random()*1000);
    }

    public StringBuilder getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(StringBuilder creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public int getCVV() {
        return CVV;
    }

}
//3