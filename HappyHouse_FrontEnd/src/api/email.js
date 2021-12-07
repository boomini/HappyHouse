import { apiInstance } from "./index.js";

const api = apiInstance();

async function emailConfirm(emailAddress) {
  console.log("emailConfirm 호출");
  await api
    .post(`/service/mail`, emailAddress)
    .then(() => {
      console.log("메일 간다!!");
    })
    .catch(() => {
      console.log("메일 안간다ㅠㅠ");
    });
}

async function verifyCode(code) {
  console.log("verifyCode 호출");
  let ret = await api.post(`/service/verifyCode`, code);
  console.log("ret : " + ret);
  return ret;
}

export { emailConfirm, verifyCode };
