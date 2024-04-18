from bottle import route, run

@route('/hello')
def hello():
    return "Hello care"

run(host='localhost', port=8080, debug=True)