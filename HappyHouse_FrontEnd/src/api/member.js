import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(member, success, fail) {
  await api
    .post(`/member/login`, JSON.stringify(member))
    .then(success)
    .catch(fail);
}

async function getMemberById(memberid, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api
    .get(`/member/info/${memberid}`)
    .then(success)
    .catch(fail);
}

async function collectMemberInfo(memberid) {
  console.log("collectMemberInfo 호출됨" + memberid);
  await api.get(`/member/${memberid}`);
}

async function modifyMemberInfo(member) {
  await api.put(`/member`, JSON.stringify(member));
}

async function unregisterMember(memberid, success, fail) {
  await api
    .delete(`/member/${memberid}`)
    .then(success)
    .catch(fail);
}

async function signUpMember(member, success, fail) {
  await api
    .post(`/member`, JSON.stringify(member))
    .then(success)
    .catch(fail);
}

// function logout(success, fail)

export {
  login,
  getMemberById,
  modifyMemberInfo,
  unregisterMember,
  signUpMember,
  collectMemberInfo,
};
