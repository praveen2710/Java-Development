package com.bebetteratjava.javaadvanced.proxydp;

public class TwitterDemoMain {

	public static void main(String[] args) {
//		TwitterService service = (TwitterService)SecurityProxy.newInstance(new TwitterServiceStub());

		TwitterUserAccessData tua = new TwitterUserAccessData("I1bUqJTgB9flAgb5hw2XMfH7n"
															,"MxiVzQGYWjqxuWj1msL6sZ4EBjCqXkeMbSbDPv76uaR5hQiMLD"
															,"868945739770204160-uxqA73X1CzCPvHwuwaejykww30vLtkT"
															,"nizGrjHzGBgERIKI75rLufVjoHE4OaJER0yEfSk4imLDU");
		tua.setAccessDataInProperties();
		TwitterService service = (TwitterService)SecurityProxy.newInstance(new TwitterServiceImpl());
		System.out.println(service.getTimeline("pj_banthia"));

		service.postToTimeline("pj_banthia", "Some message that shouldn't go through.");
	}
}
