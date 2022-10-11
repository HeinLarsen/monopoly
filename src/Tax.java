public class Tax extends Field {

    public Tax(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }

    @Override
    public String onLand(Player p) {
        String s = super.onLand(p);
        s += "\n Vil du betale fast beløb(4000kr)? Tast j for ja (Ellers trækker vi et beløb der svarer til 10% af dine aktiver)";
        return s;
    }

    @Override
    protected String onAccept(Player p) {
        p.pay(this.cost);
        return p.getName() + " har betalt et fast beløb";
    }

    @Override
    protected String onReject(Player p) {
        float percentage = p.getBalance()*.1f;
        p.pay((int)percentage);
        return "Vi har trukket 10% af deres aktiver";
    }
}
