import { apiInstance } from "./index.js";

const api = apiInstance();

async function registerInterest(payload, success, fail) {
  console.log(
    "registerInterest 호출됨 " + payload.dongcode + " " + payload.memberid
  );
  await api
    .get(`/member/${payload.dongcode}/${payload.memberid}`)
    .then(success)
    .catch(fail);
  // await api
  //   .post(`/member`, payload.dongcode, payload.memberid)
  //   .then(success)
  //   .catch(fail);
}

async function deleteInterest(dongcode, memberid, success, fail) {
  await api
    .delete(`/member/${dongcode}/${memberid}`)
    .then(success)
    .catch(fail);
}

export { registerInterest, deleteInterest };
