package com.madhu;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientTest {

	public static void main(String[] args) throws UnsupportedEncodingException {

		//org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.DefHttpClient();
		// HttpClient client = new HttpClient();
		/*HttpClient httpclient = new HttpClient();
		PostMethod request = new PostMethod(
				"http://localhost:8080/rest/1/11/Account");
		request.addRequestHeader("X-DECE-Node-Id", "urn:dece:org:org:dece:9");
		request.addRequestHeader("VHOST", "cache");
		request.addRequestHeader("DECE", "urn:dece:org:org:dece:9");*/
		//request.addRequestHeader("Content-Type", "application/xml");
		/*List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("subject", "sunitha.venkatp@gmail.com"));
		params.add(new BasicNameValuePair("responseType", "urn:dece:type:tokenprofile:saml2"));
		params.add(new BasicNameValuePair("SAMLRequest", "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48c2FtbDJwOkF1dGhuUmVxdWVzdCB4bWxuczpzYW1sMnA9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpwcm90b2NvbCIgQXNzZXJ0aW9uQ29uc3VtZXJTZXJ2aWNlVVJMPSJodHRwczovL3N0ZGVjcWF2dXRsMS52YS5uZXVzdGFyLmNvbToyNDg1L3NpbXBsZXNhbWwvbW9kdWxlLnBocC9zYW1sL3NwL3NhbWwyLWFjcy5waHAvQzBDRUY4RTA4Q0UxQzdENkUwNDAxRjBBMDU5OTEyMEIiIERlc3RpbmF0aW9uPSJodHRwczovL3FhLnMudXZ2dS5jb206NzAwMS9zZWN1cml0eS9kZWxlZ2F0aW9uL3NhbWwvbG9naW5zZXJ2aWNlL2xvZ2luIiBGb3JjZUF1dGhuPSJ0cnVlIiBJRD0iMzc4YmM0ODAtMjY0OS00NjQ5LWJmZDYtZThiMTA1NjhhM2Y3IiBJc3N1ZUluc3RhbnQ9IjIwMTQtMDUtMTJUMTI6MjQ6MTYuMDJaIiBQcm90b2NvbEJpbmRpbmc9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpiaW5kaW5nczpIVFRQLVBPU1QiIFZlcnNpb249IjIuMCI%2BPHNhbWwyOklzc3VlciB4bWxuczpzYW1sMj0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmFzc2VydGlvbiI%2BdXJuOmRlY2U6b3JnOm9yZzpkZWNlOlJFVDwvc2FtbDI6SXNzdWVyPjxzYW1sMnA6TmFtZUlEUG9saWN5IEFsbG93Q3JlYXRlPSJ0cnVlIiBGb3JtYXQ9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpuYW1laWQtZm9ybWF0OnRyYW5zaWVudCIvPjxzYW1sMnA6RXh0ZW5zaW9ucz48bnM0OlBvbGljeUxpc3QgeG1sbnM6bnM0PSJodHRwOi8vd3d3LmRlY2VsbGMub3JnL3NjaGVtYS8yMDEzLzEwL2Nvb3JkaW5hdG9yIj48bnM0OlBvbGljeT48bnM0OlBvbGljeUNsYXNzPnVybjpkZWNlOnR5cGU6cG9saWN5OlVzZXJMaW5rQ29uc2VudDwvbnM0OlBvbGljeUNsYXNzPjwvbnM0OlBvbGljeT48L25zNDpQb2xpY3lMaXN0Pjwvc2FtbDJwOkV4dGVuc2lvbnM%2BPHNhbWwyOkNvbmRpdGlvbnMgeG1sbnM6c2FtbDI9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphc3NlcnRpb24iPjxzYW1sMjpBdWRpZW5jZVJlc3RyaWN0aW9uPjxzYW1sMjpBdWRpZW5jZT51cm46ZGVjZTpvcmc6b3JnOmRlY2U6UkVUPC9zYW1sMjpBdWRpZW5jZT48L3NhbWwyOkF1ZGllbmNlUmVzdHJpY3Rpb24%2BPC9zYW1sMjpDb25kaXRpb25zPjxzYW1sMjpTdWJqZWN0IHhtbG5zOnNhbWwyPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXNzZXJ0aW9uIj48c2FtbDI6TmFtZUlEIEZvcm1hdD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOm5hbWVpZC1mb3JtYXQ6cGVyc2lzdGVudCI%2Bc3VuaXRoYS52ZW5rYXRwQGdtYWlsLmNvbTwvc2FtbDI6TmFtZUlEPjwvc2FtbDI6U3ViamVjdD48U2lnbmF0dXJlIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj48U2lnbmVkSW5mbz48Q2Fub25pY2FsaXphdGlvbk1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ii8%2BPFNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNyc2Etc2hhMSIvPjxSZWZlcmVuY2UgVVJJPSIjMzc4YmM0ODAtMjY0OS00NjQ5LWJmZDYtZThiMTA1NjhhM2Y3Ij48VHJhbnNmb3Jtcz48VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI2VudmVsb3BlZC1zaWduYXR1cmUiLz48L1RyYW5zZm9ybXM%2BPERpZ2VzdE1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNzaGExIi8%2BPERpZ2VzdFZhbHVlPjdpZXkvSFBJYUdzTjJYR0JzUkVnalRBaG5XZz08L0RpZ2VzdFZhbHVlPjwvUmVmZXJlbmNlPjwvU2lnbmVkSW5mbz48U2lnbmF0dXJlVmFsdWU%2BRHQvSm9ONVJ3dUJITU1JSVhRUzB5V05MeHgrdzZCNkxTSEVnYmxRUGhkM0Y3OWNlZzJGVG9Xa3Z0RVdJV2JlZUtPbWlZaWUwSlVoNwprSm5tZ0ZDZHltb3FleFE3dEE4UzB4L1VGMlhwYUR3VnBhRmduekcvRkJTMUZDMTZncXJvOVhxbmdHeEdqUzFzQWxmaHFSM1ljRVJMCkNnR2IzSmg3TlNuV0JKaTcvd0gxeWVSKy9HaGVsalRlbzdDcUd1R3hXVlJ3dXkvZFNYSCtSUnV2QmR3eGFNb0RLWHBqR0VVSGdoUVgKOE5aOERFYmhwTmhkZFhId0trVkZETXViL0MxUjArY0ZMY3dTU2ZNcVNNN3ErUDFzaHRibDNsMy9ZMHd0Y0FpajVibmZtMU5uRFY4aApZZGlKdFJlQ1dWT09Sb3hINmszbVk5OTRMWGh2ZFVUWXhRVVorZHZBSFlzUnpDZ0Q4clRWS0tjRzBodVNXTGNXc0F6aitONXlOUnQ3CmpidnNjM2wvT1Y5MDhKd3NNc0x6azFuYWtYbjEyZzF0cVZQb3hKamMzMFpLYVFjWnBVeHZFNXI1MmtNRFN3YjF5VjhDUlV6djRQTGMKbHM3Ui9IR1RKeWV5RWJKWWtJdCtjaGZ5eEVoMGlOS0l4SkwwTHVWTU8zWjNTZHVTYThQUkZXaGZvTjJGYjZIME5ZQ1NOTk1Sb3R5WAo0eFFnRzlXYzdRVXRBTGtqWWpvS2d4TjVDNk1jN2pGZzhwRlh4SlVvN3crb1VqZkZVeUN0N2xjaTZ6WTBJQ295V1hIVlR1OUFKWUtTCmhSSmNqOGlXUy9ZUHRlbll5Z0diN0NpeDFHT2UxRU1idWNyVndWM3ZuemU3ZU9kMi9RK3hQMXFMNThWRXNlWXp3WW1aNnJYYmRCYz08L1NpZ25hdHVyZVZhbHVlPjxLZXlJbmZvPjxYNTA5RGF0YT48WDUwOVN1YmplY3ROYW1lPjEuMi44NDAuMTEzNTQ5LjEuOS4xPSMxNjBmNjY2ZjZmNDA2ZTY1NzU3Mzc0NjE3MjJlNjM2ZjZkLENOPXVybjpkZWNlOm9yZzpvcmc6ZGVjZTpSRVQsTD1TdGVybGluZyxTVD1WQSxDPVVTPC9YNTA5U3ViamVjdE5hbWU%2BPFg1MDlDZXJ0aWZpY2F0ZT5NSUlEenpDQ0F6Z0NBZ1ZpTUEwR0NTcUdTSWIzRFFFQkJRVUFNR294RURBT0JnTlZCQW9UQjA1bGRYTjBZWEl4Q3pBSkJnTlZCQXNUCkFsRkJNUkV3RHdZRFZRUUhFd2hUZEdWeWJHbHVaekVSTUE4R0ExVUVDQk1JVm1seVoybHVhV0V4Q3pBSkJnTlZCQVlUQWxWVE1SWXcKRkFZRFZRUURFdzF1WlhWemRHRnlMbkZoTG1OaE1CNFhEVEV6TURVek1ERTBNemN5TUZvWERURTRNRFV5T1RFME16Y3lNRm93Y1RFTApNQWtHQTFVRUJoTUNWVk14Q3pBSkJnTlZCQWdUQWxaQk1SRXdEd1lEVlFRSEV3aFRkR1Z5YkdsdVp6RWlNQ0FHQTFVRUF4TVpkWEp1Ck9tUmxZMlU2YjNKbk9tOXlaenBrWldObE9sSkZWREVlTUJ3R0NTcUdTSWIzRFFFSkFSWVBabTl2UUc1bGRYTjBZWEl1WTI5dE1JSUMKSWpBTkJna3Foa2lHOXcwQkFRRUZBQU9DQWc4QU1JSUNDZ0tDQWdFQXp2NVYrbE5UUVJZZGx2VFNCeEVaeFd2anpuaWdrVSs2c2tZRApHNzg5MlAwbGxvdHRpREoyallKUUNCV2VkV25KZUFoQlZ5TXh1SWJnM1d4YktXWGhNUFgrbGJPUmFMYmJmdGUyRzBJdkNJelR1TmJXCklEalJzNm4yQXBKc3BIRTc5b0FNSDEyeCtad1hHOFlvUi9UVmNVMi9hYjRPd0NOa3MwL2hmMzlTb3MzejBjeXNoczF2SERYWmE2T2wKSy9NNnloV0dydmRZclF2VUVpSzNuMHlpS0VIZ3FnRFoyRlFZM3FQNWZDSEtyeGNIb2JzMmx1aTlxb2pTLzNvU1dBeWl3VTh4NUtWMQprVGh2VE9uZ0ZSMnFOejJwTElhaUtEbnB6ZHZMR1VLaisvbXJOc1RpVU1jMFNWcVRaT3lYdWU4VTI0TDlmVFBuQ0RVLzVSSE9nMDlFCnUyeWMrLzFTYWpsZlpKRGpEa1JnaXJTbEF0dkVLbkdkVzlVYkNDU1o5VUxMRWpydHhzK3gvUVNETnZPWUZzTVhVeGJpUk5Zd0p5QncKdDZEM0FPS0NHUGVlSFRZREtwRER4NmhBMUQyRm91N3pjVGJnRGdUclBtN0kxY3MyR1BBOTZjUzZIR0RuWlFNN2h5QmFlazZiWHpvawo2SW1OQklVdnRYSVdBS3IxSDNFbkZTcDZEQmp2cEVZbUt3cldhU2dVbFM2UXR5MFRyUTI4QS94T2ExbUs2azRqMXRJOFVEckg3N2hOCkxlT2t2ZlF3QTU0QWJ3bS9TaTBWdmxhYjJlR1hTbkxJSGMrOEdyQ1NRQk1OVFNwUFYxYnNONVY0cWllTHgvVnZjMW9tdUxiTGk4WTMKeHBpYzk4OWpnRFJMNXplSXZtWTZPek1kSGJLYWxiNU5PcGFSWXEwQ0F3RUFBVEFOQmdrcWhraUc5dzBCQVFVRkFBT0JnUUMwVURqVQo4OHlNeUE2WG95alhIRCswNnpnTkpmUFhwRGQ1dFBXRmpvZnRYcTZ1QWRLMWh6cERiWFNMaDVoMU0vZWdKQkY0aEdjT0RmVlhFM2RhClViL2pYNjFOUkFHeE5TQ1hSQkJtaEE4K29wTHR5WVZWY050TWJQTlJyMm9vaHhnd3NsdEtuUlBkV2kyQ0FrOVRoaFZ2OCtrK3l2YzQKekFVbGZyQmo2MzJDVXc9PTwvWDUwOUNlcnRpZmljYXRlPjwvWDUwOURhdGE%2BPC9LZXlJbmZvPjwvU2lnbmF0dXJlPjwvc2FtbDJwOkF1dGhuUmVxdWVzdD4%3D"));
		request.setEntity(new UrlEncodedFormEntity((List<? extends org.apache.http.NameValuePair>) params));
		*/
		
		/*HttpClient client = new DefaultHttpClient();
		HttpPost request = new HttpPost(
				"http://localhost:8080/rest/1/11/VerificationToken/urn:dece:type:token:DelegationTokenRequest:VerifiedEmail");
		request.addHeader("X-DECE-Node-Id", "urn:dece:org:org:dece:9");
		request.addHeader("VHOST", "cache");
		request.addHeader("DECE", "urn:dece:org:org:dece:9");
		
		StringRequestEntity stringRequestEntity = new StringRequestEntity(
				"<?xml version=\"1.0\" encoding=\"utf-8\"?><Account xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.decellc.org/schema/2013/10/coordinator\"><DisplayName>Elena Gery 3590</DisplayName><Country>US</Country></Account>");
		request.setRequestEntity(stringRequestEntity);
		HttpResponse response;
		try {
			response = client.execute(request);
			System.out.println(">>>>> status code  " + response);
			//System.out.println(">>>>>   " + request.getStatusText());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		/* StringRequestEntity stringRequestEntity = new StringRequestEntity("<?xml version=\"1.0\" encoding=\"utf-8\"?><Account xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.decellc.org/schema/2013/10/coordinator\"><DisplayName>Elena Gery 3590</DisplayName><Country>US</Country></Account>");
		 request.setRequestEntity(stringRequestEntity);
		int statusCode = 0;
		try {
			statusCode = httpclient.executeMethod(request);
			System.out.println(">>>>> status code  " + statusCode);
			System.out.println(">>>>>   " + request.getStatusText());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost request = new HttpPost(
				"http://localhost:8080/rest/1/11/VerificationToken/urn:dece:type:token:DelegationTokenRequest:VerifiedEmail");
		request.addHeader("X-DECE-Node-Id", "urn:dece:org:org:dece:9");
		request.addHeader("VHOST", "cache");
		request.addHeader("DECE", "urn:dece:org:org:dece:9");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("subject", "sunitha.venkatp@gmail.com"));
		params.add(new BasicNameValuePair("responseType", "urn:dece:type:tokenprofile:saml2"));
		params.add(new BasicNameValuePair("SAMLRequest", "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48c2FtbDJwOkF1dGhuUmVxdWVzdCB4bWxuczpzYW1sMnA9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpwcm90b2NvbCIgQXNzZXJ0aW9uQ29uc3VtZXJTZXJ2aWNlVVJMPSJodHRwczovL3N0ZGVjcWF2dXRsMS52YS5uZXVzdGFyLmNvbToyNDg1L3NpbXBsZXNhbWwvbW9kdWxlLnBocC9zYW1sL3NwL3NhbWwyLWFjcy5waHAvQzBDRUY4RTA4Q0UxQzdENkUwNDAxRjBBMDU5OTEyMEIiIERlc3RpbmF0aW9uPSJodHRwczovL3FhLnMudXZ2dS5jb206NzAwMS9zZWN1cml0eS9kZWxlZ2F0aW9uL3NhbWwvbG9naW5zZXJ2aWNlL2xvZ2luIiBGb3JjZUF1dGhuPSJ0cnVlIiBJRD0iMzc4YmM0ODAtMjY0OS00NjQ5LWJmZDYtZThiMTA1NjhhM2Y3IiBJc3N1ZUluc3RhbnQ9IjIwMTQtMDUtMTJUMTI6MjQ6MTYuMDJaIiBQcm90b2NvbEJpbmRpbmc9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpiaW5kaW5nczpIVFRQLVBPU1QiIFZlcnNpb249IjIuMCI%2BPHNhbWwyOklzc3VlciB4bWxuczpzYW1sMj0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmFzc2VydGlvbiI%2BdXJuOmRlY2U6b3JnOm9yZzpkZWNlOlJFVDwvc2FtbDI6SXNzdWVyPjxzYW1sMnA6TmFtZUlEUG9saWN5IEFsbG93Q3JlYXRlPSJ0cnVlIiBGb3JtYXQ9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpuYW1laWQtZm9ybWF0OnRyYW5zaWVudCIvPjxzYW1sMnA6RXh0ZW5zaW9ucz48bnM0OlBvbGljeUxpc3QgeG1sbnM6bnM0PSJodHRwOi8vd3d3LmRlY2VsbGMub3JnL3NjaGVtYS8yMDEzLzEwL2Nvb3JkaW5hdG9yIj48bnM0OlBvbGljeT48bnM0OlBvbGljeUNsYXNzPnVybjpkZWNlOnR5cGU6cG9saWN5OlVzZXJMaW5rQ29uc2VudDwvbnM0OlBvbGljeUNsYXNzPjwvbnM0OlBvbGljeT48L25zNDpQb2xpY3lMaXN0Pjwvc2FtbDJwOkV4dGVuc2lvbnM%2BPHNhbWwyOkNvbmRpdGlvbnMgeG1sbnM6c2FtbDI9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphc3NlcnRpb24iPjxzYW1sMjpBdWRpZW5jZVJlc3RyaWN0aW9uPjxzYW1sMjpBdWRpZW5jZT51cm46ZGVjZTpvcmc6b3JnOmRlY2U6UkVUPC9zYW1sMjpBdWRpZW5jZT48L3NhbWwyOkF1ZGllbmNlUmVzdHJpY3Rpb24%2BPC9zYW1sMjpDb25kaXRpb25zPjxzYW1sMjpTdWJqZWN0IHhtbG5zOnNhbWwyPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXNzZXJ0aW9uIj48c2FtbDI6TmFtZUlEIEZvcm1hdD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOm5hbWVpZC1mb3JtYXQ6cGVyc2lzdGVudCI%2Bc3VuaXRoYS52ZW5rYXRwQGdtYWlsLmNvbTwvc2FtbDI6TmFtZUlEPjwvc2FtbDI6U3ViamVjdD48U2lnbmF0dXJlIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj48U2lnbmVkSW5mbz48Q2Fub25pY2FsaXphdGlvbk1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ii8%2BPFNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNyc2Etc2hhMSIvPjxSZWZlcmVuY2UgVVJJPSIjMzc4YmM0ODAtMjY0OS00NjQ5LWJmZDYtZThiMTA1NjhhM2Y3Ij48VHJhbnNmb3Jtcz48VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI2VudmVsb3BlZC1zaWduYXR1cmUiLz48L1RyYW5zZm9ybXM%2BPERpZ2VzdE1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNzaGExIi8%2BPERpZ2VzdFZhbHVlPjdpZXkvSFBJYUdzTjJYR0JzUkVnalRBaG5XZz08L0RpZ2VzdFZhbHVlPjwvUmVmZXJlbmNlPjwvU2lnbmVkSW5mbz48U2lnbmF0dXJlVmFsdWU%2BRHQvSm9ONVJ3dUJITU1JSVhRUzB5V05MeHgrdzZCNkxTSEVnYmxRUGhkM0Y3OWNlZzJGVG9Xa3Z0RVdJV2JlZUtPbWlZaWUwSlVoNwprSm5tZ0ZDZHltb3FleFE3dEE4UzB4L1VGMlhwYUR3VnBhRmduekcvRkJTMUZDMTZncXJvOVhxbmdHeEdqUzFzQWxmaHFSM1ljRVJMCkNnR2IzSmg3TlNuV0JKaTcvd0gxeWVSKy9HaGVsalRlbzdDcUd1R3hXVlJ3dXkvZFNYSCtSUnV2QmR3eGFNb0RLWHBqR0VVSGdoUVgKOE5aOERFYmhwTmhkZFhId0trVkZETXViL0MxUjArY0ZMY3dTU2ZNcVNNN3ErUDFzaHRibDNsMy9ZMHd0Y0FpajVibmZtMU5uRFY4aApZZGlKdFJlQ1dWT09Sb3hINmszbVk5OTRMWGh2ZFVUWXhRVVorZHZBSFlzUnpDZ0Q4clRWS0tjRzBodVNXTGNXc0F6aitONXlOUnQ3CmpidnNjM2wvT1Y5MDhKd3NNc0x6azFuYWtYbjEyZzF0cVZQb3hKamMzMFpLYVFjWnBVeHZFNXI1MmtNRFN3YjF5VjhDUlV6djRQTGMKbHM3Ui9IR1RKeWV5RWJKWWtJdCtjaGZ5eEVoMGlOS0l4SkwwTHVWTU8zWjNTZHVTYThQUkZXaGZvTjJGYjZIME5ZQ1NOTk1Sb3R5WAo0eFFnRzlXYzdRVXRBTGtqWWpvS2d4TjVDNk1jN2pGZzhwRlh4SlVvN3crb1VqZkZVeUN0N2xjaTZ6WTBJQ295V1hIVlR1OUFKWUtTCmhSSmNqOGlXUy9ZUHRlbll5Z0diN0NpeDFHT2UxRU1idWNyVndWM3ZuemU3ZU9kMi9RK3hQMXFMNThWRXNlWXp3WW1aNnJYYmRCYz08L1NpZ25hdHVyZVZhbHVlPjxLZXlJbmZvPjxYNTA5RGF0YT48WDUwOVN1YmplY3ROYW1lPjEuMi44NDAuMTEzNTQ5LjEuOS4xPSMxNjBmNjY2ZjZmNDA2ZTY1NzU3Mzc0NjE3MjJlNjM2ZjZkLENOPXVybjpkZWNlOm9yZzpvcmc6ZGVjZTpSRVQsTD1TdGVybGluZyxTVD1WQSxDPVVTPC9YNTA5U3ViamVjdE5hbWU%2BPFg1MDlDZXJ0aWZpY2F0ZT5NSUlEenpDQ0F6Z0NBZ1ZpTUEwR0NTcUdTSWIzRFFFQkJRVUFNR294RURBT0JnTlZCQW9UQjA1bGRYTjBZWEl4Q3pBSkJnTlZCQXNUCkFsRkJNUkV3RHdZRFZRUUhFd2hUZEdWeWJHbHVaekVSTUE4R0ExVUVDQk1JVm1seVoybHVhV0V4Q3pBSkJnTlZCQVlUQWxWVE1SWXcKRkFZRFZRUURFdzF1WlhWemRHRnlMbkZoTG1OaE1CNFhEVEV6TURVek1ERTBNemN5TUZvWERURTRNRFV5T1RFME16Y3lNRm93Y1RFTApNQWtHQTFVRUJoTUNWVk14Q3pBSkJnTlZCQWdUQWxaQk1SRXdEd1lEVlFRSEV3aFRkR1Z5YkdsdVp6RWlNQ0FHQTFVRUF4TVpkWEp1Ck9tUmxZMlU2YjNKbk9tOXlaenBrWldObE9sSkZWREVlTUJ3R0NTcUdTSWIzRFFFSkFSWVBabTl2UUc1bGRYTjBZWEl1WTI5dE1JSUMKSWpBTkJna3Foa2lHOXcwQkFRRUZBQU9DQWc4QU1JSUNDZ0tDQWdFQXp2NVYrbE5UUVJZZGx2VFNCeEVaeFd2anpuaWdrVSs2c2tZRApHNzg5MlAwbGxvdHRpREoyallKUUNCV2VkV25KZUFoQlZ5TXh1SWJnM1d4YktXWGhNUFgrbGJPUmFMYmJmdGUyRzBJdkNJelR1TmJXCklEalJzNm4yQXBKc3BIRTc5b0FNSDEyeCtad1hHOFlvUi9UVmNVMi9hYjRPd0NOa3MwL2hmMzlTb3MzejBjeXNoczF2SERYWmE2T2wKSy9NNnloV0dydmRZclF2VUVpSzNuMHlpS0VIZ3FnRFoyRlFZM3FQNWZDSEtyeGNIb2JzMmx1aTlxb2pTLzNvU1dBeWl3VTh4NUtWMQprVGh2VE9uZ0ZSMnFOejJwTElhaUtEbnB6ZHZMR1VLaisvbXJOc1RpVU1jMFNWcVRaT3lYdWU4VTI0TDlmVFBuQ0RVLzVSSE9nMDlFCnUyeWMrLzFTYWpsZlpKRGpEa1JnaXJTbEF0dkVLbkdkVzlVYkNDU1o5VUxMRWpydHhzK3gvUVNETnZPWUZzTVhVeGJpUk5Zd0p5QncKdDZEM0FPS0NHUGVlSFRZREtwRER4NmhBMUQyRm91N3pjVGJnRGdUclBtN0kxY3MyR1BBOTZjUzZIR0RuWlFNN2h5QmFlazZiWHpvawo2SW1OQklVdnRYSVdBS3IxSDNFbkZTcDZEQmp2cEVZbUt3cldhU2dVbFM2UXR5MFRyUTI4QS94T2ExbUs2azRqMXRJOFVEckg3N2hOCkxlT2t2ZlF3QTU0QWJ3bS9TaTBWdmxhYjJlR1hTbkxJSGMrOEdyQ1NRQk1OVFNwUFYxYnNONVY0cWllTHgvVnZjMW9tdUxiTGk4WTMKeHBpYzk4OWpnRFJMNXplSXZtWTZPek1kSGJLYWxiNU5PcGFSWXEwQ0F3RUFBVEFOQmdrcWhraUc5dzBCQVFVRkFBT0JnUUMwVURqVQo4OHlNeUE2WG95alhIRCswNnpnTkpmUFhwRGQ1dFBXRmpvZnRYcTZ1QWRLMWh6cERiWFNMaDVoMU0vZWdKQkY0aEdjT0RmVlhFM2RhClViL2pYNjFOUkFHeE5TQ1hSQkJtaEE4K29wTHR5WVZWY050TWJQTlJyMm9vaHhnd3NsdEtuUlBkV2kyQ0FrOVRoaFZ2OCtrK3l2YzQKekFVbGZyQmo2MzJDVXc9PTwvWDUwOUNlcnRpZmljYXRlPjwvWDUwOURhdGE%2BPC9LZXlJbmZvPjwvU2lnbmF0dXJlPjwvc2FtbDJwOkF1dGhuUmVxdWVzdD4%3D"));
		request.setEntity(new UrlEncodedFormEntity((List<? extends org.apache.http.NameValuePair>) params));
		
		try {
			HttpResponse res = httpclient.execute(request);
			System.out.println(">>>>>>>"+res);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}